import React, { Component } from 'react';
import classes from './Restorans.module.css';
import Restoran from '../../components/Restoran/Restoran';
import instance from '../../axios-restoran';
import Modal from '../../components/UI/Modal/Modal';
import Button from '../../components/UI/Button/Button';
import Pagination from '../../components/UI/Pagination/Pagination';

class Restorans extends Component{
    constructor(props){
        super(props);
        this.state = {
            restorans:[],
            isCreate:false,
            isLoading: true,
            isEdit:false,
            idRestoran:"",
            nama:"",
            alamat:"",
            nomorTelepon:"",
            rating:"",
            currentPage:1,
            itemPerPage: 5
        }
    }
    paginationClickHandler = event =>{
        this.setState({
            currentPage: Number(event.target.id)
        });
    }
    componentDidMount(){
        this.loadRestorans();
    }
    loadRestorans = async () => {
        const fetchedRestorans = [];
        const response = await instance.get("/restorans");
        for(let key in response.data){
            fetchedRestorans.push({
                ...response.data[key]
            });
        }
        this.setState({
            restorans: fetchedRestorans
        });
    }
    addRestoranHandler = () => {
        this.setState({isCreate:true});
    }
    editRestoranHandler(restoran){
        this.setState({
            isEdit:true,
            idRestoran:restoran.idRestoran,
            nama:restoran.nama,
            nomorTelepon:restoran.nomorTelepon,
            rating: restoran.rating,
            alamat:restoran.alamat
        })
    }
    canceledHandler = () => {
        this.setState({isCreate:false, isEdit:false});
    }
    updateSearchValue = event =>{
        event.preventDefault();
        this.setState({isLoading:true});
        const value = event.target.value;
        this.searchRestoranHandler(value);
        
    }
    changeHandler = event => {
        const { name,value } = event.target;
        this.setState({[name]:value});
    };
    submitAddRestoranHandler = event => {
        event.preventDefault();
        this.setState({isLoading:true});
        this.addRestoran();
        this.canceledHandler();
        this.setState({nama:""});
        this.setState({nomorTelepon:""});
        this.setState({alamat:""});
        this.setState({rating:""});
    }
    async addRestoran(){
        const restoranToAdd={
            nama:this.state.nama,
            alamat:this.state.alamat,
            nomorTelepon:this.state.nomorTelepon,
            rating:this.state.rating

        };
        await instance.post("/restoran",restoranToAdd);
        await this.loadRestorans();
    }
    submitEditRestoranHandler = event => {
        event.preventDefault();
        this.setState({isLoading:true});
        this.editRestoran();
        this.canceledHandler();
        this.setState({nama:""});
        this.setState({nomorTelepon:""});
        this.setState({alamat:""});
        this.setState({rating:""});
    }
    async editRestoran(){
        const restoranToEdit={
            idRestoran: this.state.idRestoran,
            nama: this.state.nama,
            alamat:this.state.alamat,
            nomorTelepon: this.state.nomorTelepon,
            rating:this.state.rating
        }
        await instance.put("/restoran/" + this.state.idRestoran, restoranToEdit);
        await this.loadRestorans();
        this.canceledHandler();
    }
    async deleteRestoranHandler(restoranId){
        await instance.delete(`/restoran/${restoranId}`);
        await this.loadRestorans();
    }
    async searchRestoranHandler(nama){
        if(nama===""){
            this.loadRestorans();
        }else{
            const fetchedRestorans = [];
            const response = await instance.get(`/search/${nama}`);
            for(let key in response.data){
                fetchedRestorans.push({
                    ...response.data[key]
                });
            }
            this.setState({
                restorans: fetchedRestorans
            });
        }
    }
    renderForm(){
        return(
            <form>
                <div className="row">
                    <input 
                    className={classes.Input} name="nama" 
                    type="text" placeholder="Nama"
                    value={this.state.nama}
                    onChange={this.changeHandler} />
                    <input 
                    className={classes.Input} name="nomorTelepon" 
                    type="number" placeholder="Nomor Telepon"
                    value={this.state.nomorTelepon}
                    onChange={this.changeHandler}/>
                </div>
                <div className="row">
                    <textarea 
                    className={classes.TextArea} name="alamat" 
                    type="text" placeholder="Alamat"
                    value={this.state.alamat}
                    onChange={this.changeHandler}/>
                    <input 
                    className={classes.Input} name="rating" 
                    type="number" placeholder="Rating"
                    value={this.state.rating}
                    onChange={this.changeHandler}/>
                </div>
                <div className="row">
                    <Button btnType="Danger" onClick={this.canceledHandler}>CANCEL</Button>
                    <Button btnType="Success" onClick={ this.state.isEdit ? this.submitEditRestoranHandler : this.submitAddRestoranHandler}>SUBMIT</Button>
                </div>
            </form>
        );
    }
    render(){
        const { restorans, currentPage, itemPerPage } = this.state;

        // Logic for displaying todos
        const indexOfLastItem = currentPage * itemPerPage;
        const indexOfFirstItem = indexOfLastItem - itemPerPage;
        const currentItems = restorans.slice(indexOfFirstItem, indexOfLastItem);
        const renderItems = currentItems.map((restoran) => 
             <Restoran 
                key={restoran.id}
                nama={restoran.nama}
                alamat={restoran.alamat}
                nomorTelepon={restoran.nomorTelepon}
                edit={() => this.editRestoranHandler(restoran)}
                delete={() => this.deleteRestoranHandler(restoran.idRestoran)}
            />
            
        );
        const pageNumbers = [];
        for (let i = 1; i <= Math.ceil(restorans.length / itemPerPage); i++) {
        pageNumbers.push(i);
        }
        const renderPageNumbers = pageNumbers.map(number => {
            return (
              <Pagination
              key={number}
              id={number}
              onClick={this.paginationClickHandler}
            >{number}</Pagination>
            );
        });
        return(
            <React.Fragment>
                <Modal
                show={this.state.isCreate || this.state.isEdit}
                modalClosed={this.canceledHandler}>
                    {this.renderForm()}
                </Modal>
                <div className={classes.Title}>All Restorans</div>
                <div className={classes.ButtonLayout}>
                    <button
                        className={classes.AddRestoranButton}
                        onClick={this.addRestoranHandler}>
                            + Add New Restoran

                    </button>
                </div>

                <div className={classes.SearchLayout}>
                    <input className={classes.SearchInput} placeholder="--Search Restoran--"
                    onChange={this.updateSearchValue}/>
                </div>

                <div className={classes.Restorans}>
                    {renderItems}
                </div>

                <div className={classes.PageNumberLayout}>
                    <div className={classes.PageNumbers}>
                        {renderPageNumbers}
                    </div>
                </div>
            </React.Fragment>
        );
    }
}

export default Restorans;
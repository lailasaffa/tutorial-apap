import React from 'react';
import List from "./components/List";
import dummyItems from "./items.json";

export default class App extends React.Component {
    constructor(props){
      super(props);
      this.state={
        favItems:[],
        isfavorite:false,
      };
    }
    handleMenuItem = item => {
        const newItems = [...this.state.favItems];
        const newItem = {...item};

        const targetInd = newItems.findIndex(it => it.id == newItem.id);
        newItems.push(newItem);
        this.setState({favItems: newItems});
    }
    handleFavoriteItem = item => {
        const newItems = [...this.state.favItems];
        const newItem = {...item};

        const targetInd = newItems.findIndex(it => it.id == newItem.id);
        newItems.splice(targetInd, 1);
        this.setState({favItems: newItems});
    }

    handleFavoriteCheckboxes = () => {
        if(this.state.isfavorite==false){
            this.setState({isfavorite: true});
        }
        if(this.state.isfavorite==true){
            this.setState({isfavorite: false});
        }
    }

    render(){
            const {favItems} = this.state;
            return (
                <div className="container-fluid">
                    <h1 className="text-center">
                        Welcome!
                        <small>Class-based</small>
                    </h1>
                    <div className="container pt-3">
                        <div className="row">
                            <div className="col-sm">
                            <span>
                            <input type="checkbox" aria-label="Checkbox for following text input"
                            onClick={
                                ()=>this.handleFavoriteCheckboxes()
                                }/>Show Favorites</span>
                                <List
                                    isLeft={true}
                                    title="Our Menu"
                                    items={dummyItems}
                                    onItemClick={this.handleMenuItem}
                                />
                            </div>
                            <div className="col-sm">
                                {this.state.isfavorite? <List
                                    isLeft={false}
                                    title="My Favorite"
                                    items={favItems}
                                    onItemClick={this.handleFavoriteItem}
                                /> : <div />}
                                
                            </div>
                        </div>
                    </div>
                </div>
            );

        }
    };

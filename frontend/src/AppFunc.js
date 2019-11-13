import React, { useState } from "react";
import List from "./components/List";

import dummyItems from "./items.json";
function App() {
    const [favItems, setFavItems] = useState(() => []);
    const [isFavorite, setIsFavorite] = useState(false);
    function handleItemClickKiri(item) {
        const newItems = [...favItems];
        const newItem = { ...item };
        const targetInd = newItems.findIndex(it => it.id === newItem.id);
        newItems.push(newItem);
        setFavItems(newItems);
    }
    function handleItemClickKanan(item) {
        const newItems = [...favItems];
        const newItem = { ...item };
        const targetInd = newItems.findIndex(it => it.id === newItem.id);
        newItems.splice(targetInd, 1);
        setFavItems(newItems);
    }
    function handleFavoriteCheckboxes() {
        if(isFavorite==false){
            setIsFavorite(true);
        }
        if(isFavorite==true){
            setIsFavorite(false);
        }
    }

    return (
        <div className="container-fluid">
            <h1 className="text-center">
                Welcome!
                <small>Functional</small>
            </h1>
            <div className="container pt-3">
                <div className="row">
                    <div className="col-sm">
                    <span>
                        <input type="checkbox" aria-label="Checkbox for following text input"
                        onClick={
                            ()=>handleFavoriteCheckboxes()
                            }/>Show Favorites</span>
                        <List
                            isLeft={true}
                            title="Our Menu"
                            items={dummyItems}
                            onItemClick={handleItemClickKiri}
                        />
                    </div>

                    <div className="col-sm">
                        {isFavorite ? <List
                            isLeft={false}
                            title="My Favorite"
                            items={favItems}
                            onItemClick={handleItemClickKanan}
                        /> : <div />}
                    </div>

                </div>
            </div>
        </div>
    );
}
export default App;

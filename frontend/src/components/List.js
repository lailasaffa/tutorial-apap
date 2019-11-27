import React from "react"

import Item from "./Item";
import EmptyState from "./EmptyState";

const styles = {
    heading:{
        fontFamily: "courier new"
    }
};


function List({title,items,onItemClick,isLeft}){
    if(items.length==0){
        return(
        <EmptyState />
        );
    }
    return( 
        <div className="container-fluid">
            <h3 style={styles.heading}>{title}</h3>
            <div className="list-group">
            {items.map(item => (
                <Item isLeft={isLeft}key={item.id} item={item} onChange={onItemClick}/>
            ))}

            </div>
        </div>
    );
}

export default List;
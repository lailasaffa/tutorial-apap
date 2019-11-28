import React from "react";
import classes from "./Pagination.module.css";
import Button from "../Button/Button";

const Pagination = props =>(
    <React.Fragment>
        {/* <li
        key={props.children}
        id={props.children}
        onClick={props.onClick}
        className={classes.Page}>
        {props.children}
    </li> */}
        <div className="row">
            <p
            key={props.children}
            id={props.children}
            onClick={props.onClick}
            className={classes.Page}>
            {props.children}</p>
        </div>
        
    </React.Fragment>
      
);

export default Pagination;
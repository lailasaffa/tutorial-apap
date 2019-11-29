import React from "react";
import classes from "./Pagination.module.css";
import Button from "../Button/Button";

const Pagination = props =>(
    <React.Fragment>
        <a
        key={props.children}
        id={props.children}
        onClick={props.onClick}
        className={[classes.Page, classes[props.activeClass]].join(" ")}
        >
        {props.children}</a>
        
    </React.Fragment>
      
);

export default Pagination;
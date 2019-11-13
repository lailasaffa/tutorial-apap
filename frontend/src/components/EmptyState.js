import React from "react"

import Item from "./Item";

const styles = {
    heading:{
        fontFamily: "courier new"
    }
};

function EmptyState(){
    return(
        <div className="container-fluid">
            <h3 style={styles.heading}>My Favorite</h3>
            <div className="text-center">
                <h2><strong>Belum ada item yang dipilih</strong></h2>
                <p>Klik Salah Satu Item di Daftar Menu</p>
            </div>
        </div>
    );
}

export default EmptyState;
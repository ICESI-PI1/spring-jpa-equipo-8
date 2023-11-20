import React from "react";
import 'bootstrap/dist/css/bootstrap.min.css';

export const Popup = ({ text, closePopup }) => {
    return (
        <div style={{bottom: '2rem', backgroundColor: 'rgba(0,0,0,0.8)'}} className="rounded text-white position-absolute p-3">
            <div className="d-flex align-items-center" style={{gap: '2rem'}}>
                <div className="fs-5">
                    {text}
                </div>
                <button className="btn btn-secondary" onClick={closePopup}>Cerrar</button>
            </div>
        </div>
    );
};

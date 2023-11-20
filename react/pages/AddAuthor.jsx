import React from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap/dist/js/bootstrap.bundle.min';
import { useState, useEffect } from "react"
import instance from "../config/axios";

function AddAutor() {

    const [id,setId] = useState()
    const [name,setName] = useState("")
    const [nationality,setNationality] = useState("")

    const onAddAutor =() => {
        let autor = {id, name, nationality}
        instance.post("autores", autor)
        .then(res => {
            if (res.status == 200) {
                alert('Autor añadido exitosamente')
                window.location.href = '/';
            }
        }).catch(err => {
            alert(err.message)
        })
    }

    const getNextId = async () => {
        try {
            const response = await instance.get(`autorId`)
            setId(response.data)
          }catch (e) {
            console.log(e)
          }
    }

    useEffect(()=> {getNextId()},[])

    return (
        <div className="pt-5">
        <div className="card container">
        <form action="/AddAuthor" method="post" className="p-4">
            <div className="space-y-3 ">
                <div className="border-bottom border-1 pb-3">
                    <h2 className="h2 font-weight-bold text-dark pt-3">Añadir Autor</h2>
                    <p className="mt-1 text-muted">Ingresa los detalles del autor</p>

                    <div className="mt-4 row g-3 ">
                        <div className="col-12 col-sm-6">
                            <label htmlFor="title" className="form-label">Nombre</label>
                            <input type="text" name="name" id="name" required className="form-control" value={name} onInput={t => setName(t.target.value)} />
                        </div>

                        <div className="col-12 col-sm-6">
                            <label htmlFor="author" className="form-label">Nacionalidad</label>
                            <input type="text" name="author" id="author" required className="form-control" value={nationality} onInput={t => setNationality(t.target.value)}/>
                        </div>

                    </div>
                </div>
            </div>

            <div className="d-flex pb-3 pt-3  justify-content-end ">
                <a href="/" className="btn btn-hover">Cancelar</a>
                <a href="/"  onClick={() => onAddAutor()} className="btn" style={{ marginLeft: '10px', backgroundColor: "black", color: "white"}}>Guardar</a>
            </div>
        </form>
        </div>
    </div>
    );
}


export default AddAutor;

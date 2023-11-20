import React from 'react';
import { useState, useEffect } from "react"
import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap/dist/js/bootstrap.bundle.min';
import instance from "../config/axios";
import Select from 'react-select';


function AddBook() {

    const [title, setTitle] = useState("")
    const [realeaseDate, setRealeaseDate] = useState("")
    const [autores, setAutores] = useState([])
    const [autor, setAutor] = useState({})
    const [id,setId] = useState()

    const onAddBook =() => {
        let book = {id, title, realeaseDate, autor}
        instance.post("libros", book)
        .then(res => {
            if (res.status == 200) {
                alert('Libro añadido exitosamente')
                window.location.href = '/';
            }
        }).catch(err => {
            alert(err.message)
        })
    }

    const getId = async () => {
        try {
            const response = await instance.get(`libroId`)
            setId(response.data)
          }catch (e) {
            console.log(e)
          }
    }
    useEffect(()=> {getId()},[])

    const getAutores = async () => {
        try {
          const response = await instance.get(`autores`)
          setAutores(response.data)
        }catch (e) {
          console.log(e)
        }
    }
    useEffect(()=> {getAutores()},[])

    const getAutor = async (id) => {
        try {
          const response = await instance.get(`autores/${id}`)
          setAutor(response.data)
        }catch (e) {
          console.log(e)
        }
    }

    const handleSelectChange = (event) =>{
        getAutor(event.value)
    }

    return (
        <div className="pt-5">
        <div className="card container">
        <form action="/AddBook" method="post" className="p-4">
            <div className="space-y-3 ">
                <div className="border-bottom border-1 pb-3">
                    <h2 className="h2 font-weight-bold text-dark pt-3">Añadir libro</h2>
                    <p className="mt-1 text-muted">Ingresa los detalles del libro</p>

                    <div className="mt-4 row g-3 ">
                        <div className="col-12 col-sm-6">
                            <label htmlFor="title" className="form-label">Título</label>
                            <input type="text" name="title" id="title" required className="form-control" value={title} onInput={t => setTitle(t.target.value)} />
                        </div>

                        <div className="col-12 col-sm-6">
                            <label htmlFor="author" className="form-label">Fecha de estreno</label>
                            <input type="date" name="realeaseDate" id="realeaseDate" required className="form-control" value={realeaseDate} onInput={t => setRealeaseDate(t.target.value)} />
                        </div>

                        <div className="col-12 col-sm-6">
                          <Select
                            options={autores.map((autor)=>({label:autor.name, value:autor.id}))}
                            onChange={handleSelectChange}
                          />
                        </div>

                    </div>
                </div>
            </div>

            <div className="d-flex pb-3 pt-3  justify-content-end ">
                <a href="/" className="btn btn-hover">Cancelar</a>
                <a href="/"  onClick={() => onAddBook()} className="btn" style={{ marginLeft: '10px', backgroundColor: "black", color: "white"}} >Guardar</a>
            </div>
        </form>
        </div>
    </div>
    );
}



export default AddBook;

import React, { useState } from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap/dist/js/bootstrap.bundle.min';
import { useEffect } from "react"
import { useParams } from 'react-router-dom';
import instance from "../config/axios";
import Select from 'react-select';

function EditBook() {

    const [libro,setLibro] = useState({})
    const[title,setTitle] = useState(libro.title)
    const[releaseDate,setReleaseDate] = useState("")
    const[autor,setAutor] = useState({})
    const [autores, setAutores] = useState([])
  

    let {id} = useParams()

    const onEditBook = () => {
    
        const editedBook = { ...libro };
      
        console.log(title)
        console.log(releaseDate)
      
        if (title !== libro.title) {
          editedBook.title = title;
        }
      
        if (releaseDate !== libro.releaseDate) {
          editedBook.releaseDate = releaseDate;
        }
      
        if (autor.id !== libro.autor.id) {
          editedBook.autor = autor;
        }
      
        instance
          .put(`libros/${id}`, editedBook)
          .then((res) => {
            if (res.status === 200) {
              alert('Libro editado exitosamente');
              window.location.href = '/';
            }
          })
          .catch((err) => {
            alert(err.message);
          });
      };
      
    
    const getLibro = async () => {
        try {
        const response = await instance.get(`libros/${id}`)
        setLibro(response.data)
        setAutor(response.data.autor)
        }catch (e) {
        console.log(e)
        }
    }
    useEffect(()=> {getLibro()},[])
    console.log(autor)

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

    const autorName = autor.name

    const handleSelectChange = (event) =>{
        getAutor(event.value)
    }

    return (
        <div className="pt-5">
        <div className="card container">
        <form action="/EditBook" method="post" className="p-4">
            <div className="space-y-3 ">
                <div className="border-bottom border-1 pb-3">
                    <h2 className="h2 font-weight-bold text-dark pt-3">Editar libro</h2>
                    <p className="mt-1 text-muted">Edita los detalles del libro</p>

                    <div className="mt-4 row g-3 ">
                        <div className="col-12 col-sm-6">
                            <label htmlFor="title" className="form-label">Título</label>
                            <input type="text" defaultValue={libro.title} name="title" id="title" required className="form-control" onInput={t => setTitle(t.target.value)}/>
                            
                        </div>

                        <div className="pt-4 col-12 col-sm-6" style={{ marginTop: '23px' }}>
                            <Select
                                defaultValue={autores.find((autor) => autor.name === autorName)
                                                      ? { label: autorName, value: autor.id } : "Hola"}
                                options={autores.map((autor) => ({ label: autor.name, value: autor.id }))}
                                onChange={handleSelectChange}
                            />
                        </div>

                        <div className="col-12 col-sm-6">
                            <label htmlFor="editorial" className="form-label">Fecha de estreno</label>
                            <input type="date" defaultValue={libro.releaseDate} name="date" id="date" autoComplete="postal-code" className="form-control" onInput={t => setReleaseDate(t.target.value)}/>
                        </div>

                    </div>
                </div>
            </div>

            <div className="d-flex pb-3 pt-3  justify-content-end ">
                <a href="/" className="btn btn-hover">Cancelar</a>
                <a href="/"  onClick={() => onEditBook()} className="btn" style={{ marginLeft: '10px', backgroundColor: "black", color: "white"}}>Guardar</a>
            </div>
        </form>
        </div>
    </div>
    );
}



export default EditBook;

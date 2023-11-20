    import React, { useState } from 'react';
    import 'bootstrap/dist/css/bootstrap.min.css';
    import 'bootstrap/dist/js/bootstrap.bundle.min';
    import { useEffect } from "react"
    import { useParams } from 'react-router-dom';
    import instance from "../config/axios";

    function EditAutor() {

        const [autor, setAutor] = useState({ name: "", nationality: "" });
        const [name,setName] = useState("")
        const [nationality,setNationality] = useState("")

        let {id} = useParams()

        const onEditAutor = () => {
            const editedAutor = { id, name: name || autor.name, nationality: nationality || autor.nationality };
            instance.put(`autores/${id}`, editedAutor)
                .then((res) => {
                    if (res.status === 200) {
                        alert('Autor editado exitosamente');
                        window.location.href = '/';
                    }
                })
                .catch((err) => {
                    alert(err.message);
                });
        }

        const getAutor = async () => {
            try {
            const response = await instance.get(`autores/${id}`)
            setAutor(response.data)
            }catch (e) {
            console.log(e)
            }
        }
        useEffect(()=> {getAutor()},[])
        
        return (
            <div className="pt-5">
                <div className="card container">
                    <form action="/EditAuthor" method="post" className="p-4">
                        <div className="space-y-3">
                            <div className="border-bottom border-1 pb-3">
                                <h2 className="h2 font-weight-bold text-dark pt-3">Editar Autor</h2>
                                <p className="mt-1 text-muted">Edita los detalles del autor</p>

                                <div className="mt-4 row g-3">
                                    <div className="col-12 col-sm-6">
                                        <label htmlFor="title" className="form-label">Nombre</label>
                                        <input type="text" defaultValue={autor.name} name="title" id="title" required className="form-control" onInput={t => setName(t.target.value)}/>
                                    </div>

                                    <div className="col-12 col-sm-6">
                                        <label htmlFor="author" className="form-label">Nacionalidad</label>
                                        <input type="text" defaultValue={autor.nationality} name="author" id="author" required className="form-control" onInput={t => setNationality(t.target.value)}/>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div className="d-flex pb-3 pt-3 justify-content-end">
                            <a href="/" className="btn btn-hover">Cancelar</a>
                            <a href="/"  onClick={() => onEditAutor()} className="btn" style={{ marginLeft: '10px', backgroundColor: "black", color: "white" }}>Guardar</a>
                        </div>
                    </form>
                </div>
            </div>
        );
    }
    export default EditAutor;

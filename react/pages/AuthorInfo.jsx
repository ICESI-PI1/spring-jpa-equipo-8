import React, { useEffect } from 'react';
import 'bootstrap/dist/css/bootstrap.min.css'; // Importa el CSS de Bootstrap
import 'bootstrap/dist/js/bootstrap.bundle.min';
import './assets/styles.css';
import { useParams } from 'react-router-dom';
import { useState } from 'react';
import instance from "../config/axios";

const AuthorInfo = () => {

  const [autor,setAutor] = useState({})

  let {id} = useParams()

  const getAutor = async () => {
    try {
      const response = await instance.get(`autores/${id}`)
      setAutor(response.data)
    }catch (e) {
      console.log(e)
    }
  }
  useEffect(()=> {getAutor()},[])

  const deleteAutor = async () => {
    try {
      const response = await instance.delete(`autores/${id}`)
      window.location.href = '/'
      alert('Autor eliminado exitosamente')
    }catch (e) {
      console.log(e)
    }
  }

  return (
    <div className="pt-5">
    <div className="card container">
      <div className="p-4 rounded bg-white shadow-sm">
      <div className="px-0">
        <div className="d-flex flex-row justify-content-between   pb-3 pt-3">
          <h2 className="h2 font-weight-bold text-dark pt-3">Información del libro</h2>
          <div className="d-flex pb-3 pt-3">
          <a onClick={() => deleteAutor()} className="btn btn-hover" >Eliminar</a>
            <a href={`/editAuthor/${autor.id}`} className="btn" style={{ marginLeft: '10px', backgroundColor: "black", color: "white"}}>Editar</a>
          </div>
        </div>
        <div className="border-top my-1"></div>
        </div>
        <div className="mt-4 border-t pt-3">
          <dl className="row">
            <div className="col-6">
              <dt className="font-weight-normal">ID</dt>
              <dd className="text-muted">{autor.id}</dd>
            </div>
            <div className="col-6">
              <dt className="font-weight-normal">Nombre</dt>
              <dd className="text-muted">{autor.name}</dd>
            </div>
            <div className="col-6">
              <dt className="">Nacionalidad</dt>
              <dd className="text-muted">{autor.nationality}</dd>
            </div>
            
          </dl>
        </div>
        <div className="d-flex pb-3 pt-3 justify-content-end">
          <a href={`/`} className="btn" >Volver</a>
        </div>
      </div>
    </div>
    </div>
  );
};

export default AuthorInfo;

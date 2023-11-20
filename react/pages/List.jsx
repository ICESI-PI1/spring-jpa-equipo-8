import React, { useState } from 'react';
import { useEffect} from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap/dist/js/bootstrap.bundle.min';
import ListBooks from '/pages/ListBooks';
import ListAuthors from '/pages/ListAuthors';
import instance from "../config/axios";
import './assets/styles.css';


function List() {

  const [libros,setLibros] = useState([])
  const [autores,setAutores] = useState([])


  /*const hola = instance.post("libros", {"id": 1, "title":"Hola", "Autor":{"id":1,"name":"Gabriel","nationality":"Colombiano"}})
  console.log(hola)*/
  
  const getLibros = async () => {
    try {
      const response = await instance.get("libros")
      setLibros(response.data)
    }catch (e) {
      console.log(e)
    }
  }

  console.log(libros)
  useEffect(()=> {getLibros()},[])

  const getAutores = async () => {
    try {
      const response = await instance.get("autores")
      setAutores(response.data)
    }catch (e) {
      console.log(e)
    }
  }

  useEffect(()=> {getAutores()},[])

  return (
      <div>
          <div className='d-flex justify-content-end align-items-center p-5'>
            <button onClick={() => {localStorage.removeItem("token"); window.location.href = '/login'}} className='btn btn-add'>Cerrar sesión</button>
          </div>
          <ListBooks libros = {libros}/>
          <ListAuthors autores = {autores}/>
      </div>
  );
}

export default List;
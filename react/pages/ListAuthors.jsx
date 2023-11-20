import React from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap/dist/js/bootstrap.bundle.min';
import './assets/styles.css';


function ListAuthors({autores}) {
  return (
    <>
    <div className="container mt-5 mb-4">
      <div className="d-flex justify-content-between align-items-center">
        <h1 className="display-4 font-weight-bold">
          Autores
        </h1>
        <a href="/AddAuthor" className="btn btn-add">
          <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" strokeWidth="1.5" stroke="currentColor" className="w-6 h-6">
            <path strokeLinecap="round" strokeLinejoin="round" d="M12 4.5v15m7.5-7.5h-15" />
          </svg>
          Añadir
        </a>
      </div>
    </div>

    <div className="container mt-6">
      <div className="row">
        {autores.map((autor) => (
          <div key={autor.id} className="col-12 col-sm-6 col-lg-3 mb-4">
            <a href={`/AuthorInfo/${autor.id}`} style={{ textDecoration: 'none' }}>
              <div className="card">
                <div style={{ paddingLeft: '15px', paddingTop: '15px' }}>
                <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" strokeWidth="1.5" stroke="currentColor" className="w-6 h-6" width="35" height="35">
                        <path strokeLinecap="round" strokeLinejoin="round" d="M15.75 6a3.75 3.75 0 11-7.5 0 3.75 3.75 0 017.5 0zM4.501 20.118a7.5 7.5 0 0114.998 0A17.933 17.933 0 0112 21.75c-2.676 0-5.216-.584-7.499-1.632z" />
                      </svg>
                </div>
                <div className="card-body">
                  <h5 className="card-title">{autor.name}</h5>
                </div>
              </div>
            </a>
          </div>
        ))}
      </div>
    </div>
  </>
);
}

export default ListAuthors;

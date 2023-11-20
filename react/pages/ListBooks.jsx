import React from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap/dist/js/bootstrap.bundle.min';
import './assets/styles.css';


function ListBooks({libros}) {
  return (
    <>
    <div className="container mt-5 mb-4">
      <div className="d-flex justify-content-between align-items-center">
        <h1 className="display-4 font-weight-bold">
          Libros
        </h1>
        <a href="/AddBook" className="btn btn-add">
          <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" strokeWidth="1.5" stroke="currentColor" className="w-6 h-6">
            <path strokeLinecap="round" strokeLinejoin="round" d="M12 4.5v15m7.5-7.5h-15" />
          </svg>
          Añadir
        </a>
      </div>
    </div>

    <div className="container mt-6">
      <div className="row">
        {libros.map((libro) => (
          <div key={libro.id} className="col-12 col-sm-6 col-lg-3 mb-4">
            <a href={`/BookInfo/${libro.id}`} style={{ textDecoration: 'none' }}>
              <div className="card">
                <div style={{ paddingLeft: '15px', paddingTop: '15px' }}>
                  <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" strokeWidth={1.5} stroke="currentColor" width="35" height="35">
                    <path strokeLinecap="round" strokeLinejoin="round" d="M12 6.042A8.967 8.967 0 006 3.75c-1.052 0-2.062.18-3 .512v14.25A8.987 8.987 0 016 18c2.305 0 4.408.867 6 2.292m0-14.25a8.966 8.966 0 016-2.292c1.052 0-2.062.18 3 .512v14.25A8.987 8.987 0 0018 18a8.967 8.967 0 00-6 2.292m0-14.25v14.25" />
                  </svg>
                </div>
                <div className="card-body">
                  <h5 className="card-title" >{libro.title}</h5>
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

export default ListBooks;

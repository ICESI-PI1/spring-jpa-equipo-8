import { Route, Routes, BrowserRouter } from 'react-router-dom';

import Login from '/pages/Login';
import Register from '/pages/Register';

import List from '../pages/List'
import AddBook from '../pages/AddBook'
import AddAuthor from '../pages/AddAuthor'
import EditBook from '../pages/EditBook'
import EditAuthor from '../pages/EditAuthor'
import BookInfo from '../pages/BookInfo'
import AuthorInfo from '../pages/AuthorInfo'

import ProtectedRoute from '../pages/ProtectedRoute';

const Router = () => (
  <BrowserRouter>
    <Routes>
      <Route path="/login" element={<Login />} />
      <Route path="/register" element={<Register />} />

      <Route path="/" element={<ProtectedRoute />}>
        <Route exact path='/' element={<List />} />
      </Route>

      <Route path="/AddBook" element={<ProtectedRoute />}>
        <Route exact path='/AddBook' element={<AddBook />} />
      </Route>

      <Route path="/AddAuthor" element={<ProtectedRoute />}>
        <Route exact path='/AddAuthor' element={<AddAuthor />} />
      </Route>

      <Route path="/EditBook" element={<ProtectedRoute />}>
        <Route exact path='/EditBook/:id' element={<EditBook />} />
      </Route>

      <Route path="/EditAuthor" element={<ProtectedRoute />}>
        <Route exact path='/EditAuthor/:id' element={<EditAuthor />} />
      </Route>

      <Route path="/BookInfo" element={<ProtectedRoute />}>
        <Route exact path='/BookInfo/:id' element={<BookInfo />} />
      </Route>

      <Route path="/AuthorInfo" element={<ProtectedRoute />}>
        <Route exact path='/AuthorInfo/:id' element={<AuthorInfo />} />
      </Route>
    </Routes>
  </BrowserRouter>
)

export default Router 
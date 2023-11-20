import { Outlet, Navigate } from 'react-router-dom'

const ProtectedRoute = () => {
    const logged = (localStorage.getItem("token")!=null)
    return logged ? <Outlet /> : <Navigate to="/login" />;
}

export default ProtectedRoute
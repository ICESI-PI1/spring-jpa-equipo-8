import { useContext, useState } from "react"
import 'bootstrap/dist/css/bootstrap.min.css';
import instance from "../config/axios";
import { Popup } from "../src/Popup";

function Login() {
    const [password, setPassword] = useState("")
    const [username, setUsername] = useState("")
    const [open, setOpen] = useState(false)

    const login = () => {
        if (password == '' || username == '') {
            setOpen(true)
            return
        }

        let user = { username, password }
        instance.post("api/auth/signin", user)
            .then(res => {
                if (res.status == 200) {
                    localStorage.setItem("token", res.data.token)
                    window.location.href = '/';
                }
            }).catch(err => {
                if (err.message == 'Request failed with status code 403')
                    setOpen(true)
                else
                    alert(err)
            })
    }

    return (
        <div style={{ height: '100vh' }} className="w-100 d-flex flex-column justify-content-center align-items-center">
            {open ? <Popup text="¡Algo salió mal! Revisa tus credenciales" closePopup={() => setOpen(false)} /> : null}

            <div style={{ gap: '1rem', width: '50%' }} className="d-flex flex-column">
                <div className="fs-2 text-center mb-4">
                    Bienvenido de vuelta
                </div>

                <div>
                    <label className="fs-6">Usuario</label>
                    <input title="userField" className="mt-2 form-control form-control-lg" type="text" id="userField" value={username} onInput={t => setUsername(t.target.value)} />
                </div>

                <div>
                    <label className="fs-6">Contraseña</label>
                    <input className="mt-2 form-control form-control-lg" type="password" id="passwordField" value={password} onInput={t => setPassword(t.target.value)} />
                </div>

                <button className="mt-4 btn btn-lg" style={{backgroundColor: "black", color: "white"}} onClick={() => { login() }}>
                    Iniciar Sesión
                </button>

                <div className="mt-5 text-center fs-5">
                    <div>¿No tienes una cuenta?&nbsp;<a href="register">Registrarme</a> </div>
                </div>
            </div>
        </div>
    )
}

export default Login
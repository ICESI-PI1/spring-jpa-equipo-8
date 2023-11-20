import { useState } from "react"
import 'bootstrap/dist/css/bootstrap.min.css';
import { Popup } from "../src/Popup";
import instance from "../config/axios";

function Login() {
    const [password, setPassword] = useState("")
    const [rPassword, setRPassword] = useState("")
    const [username, setUsername] = useState("")
    const [open, setOpen] = useState(false)

    const register = () => {
        if (password != rPassword || password == '' || rPassword == '' || username == '') {
            setOpen(true)
            return
        }

        let user = { username, password }
        instance.post("api/auth/signup", user)
            .then(res => {
                if (res.status == 200) {
                    alert('Usuario registrado exitosamente')
                    window.location.href = '/login';
                }
            }).catch(err => {
                alert(err.message)
            })
    }

    return (
        <div style={{ height: '100vh' }} className="w-100 d-flex flex-column justify-content-center align-items-center">
            {open ? <Popup text="¡Algo salió mal! Revisa los campos" closePopup={() => setOpen(false)} /> : null}

            <div style={{ gap: '1rem', width: '50%' }} className="d-flex flex-column">
                <div className="fs-2 text-center mb-4">
                    Abre una Cuenta
                </div>

                <div>
                    <label className="fs-6">Usuario</label>
                    <input title="userField" className="mt-2 form-control form-control-lg" type="text" id="userField" value={username} onInput={t => setUsername(t.target.value)} />
                </div>

                <div>
                    <label className="fs-6">Contraseña</label>
                    <input className="mt-2 form-control form-control-lg" type="password" id="passwordField" value={password} onInput={t => setPassword(t.target.value)} />
                </div>

                <div>
                    <label className="fs-6">Repetir Contraseña</label>
                    <input className="mt-2 form-control form-control-lg" type="password" id="rPasswordField" value={rPassword} onInput={t => setRPassword(t.target.value)} />
                </div>

                <button onClick={() => register()} className="mt-4 btn btn-lg" style={{backgroundColor: "black", color: "white"}}>
                    Registrarme
                </button>

                <div className="mt-5 text-center fs-5">
                    <div>
                        ¿Ya tienes una cuenta? &nbsp;
                        <a href="login">Iniciar Sesión</a>
                    </div>
                </div>
            </div>
        </div>
    )
}

export default Login
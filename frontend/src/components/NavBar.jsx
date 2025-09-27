import { NavLink } from "react-router-dom"

import "../styles/components/NavBar.css"

function NavBar() {

    return (
        <nav className="navbar">
            <div className="link-box">
                <div className="nav-img-box">
                    <NavLink to="/" className="logo">
                        <img src="..." alt="BoolF1" width="30" height="24" />
                    </NavLink>
                </div>
                <div className="nav-list-box">
                    <NavLink to="/drivers">Drivers</NavLink>
                    <NavLink to="/teams">Teams</NavLink>
                </div>
            </div>
        </nav>
    )
}

export default NavBar
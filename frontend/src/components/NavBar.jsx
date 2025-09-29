import { NavLink } from "react-router-dom"

import style from "../styles/components/NavBar.module.css"

function NavBar() {

    return (
        <nav className={style.navbar}>
            <div className={style.linkBox}>
                <div className={style.navImgBox}>
                    <NavLink to="/" className={style.logo}>
                        <img src="..." alt="BoolF1" width="30" height="24" />
                    </NavLink>
                </div>
                <div className={style.navListBox}>
                    <NavLink to="/drivers">Drivers</NavLink>
                    <NavLink to="/teams">Teams</NavLink>
                </div>
            </div>
        </nav>
    )
}

export default NavBar
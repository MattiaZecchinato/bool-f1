import { NavLink } from 'react-router-dom'
import { useState } from 'react'
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

// fontawesom
import { faBarsStaggered, faXmark } from '@fortawesome/free-solid-svg-icons';

// style
import style from '../styles/components/NavBar.module.css'

function NavBar() {

    const [isMenuOpen, setIsMenuOpen] = useState(false);

    function toggleMenu() {
        setIsMenuOpen(!isMenuOpen)
    }

    return (
        <nav className={style.navbar}>
            <div className={style.linkBox}>
                <div className={style.navImgBox}>
                    <NavLink to="/" className={style.logo}>
                        <img src="/img/logo-bool-f1.png" alt="BoolF1" width="250" height="24" />
                    </NavLink>
                </div>
                <div className={style.navListBox}>
                    <NavLink to="/drivers">Drivers</NavLink>
                    <NavLink to="/teams">Teams</NavLink>
                </div>

                {/* Mobile Menu Button */}
                <div className={style.menuButton} onClick={toggleMenu}>
                    <FontAwesomeIcon
                        icon={isMenuOpen ? faXmark : faBarsStaggered}
                        onClick={() => setIsOpen(!isOpen)}
                    />
                </div>

                {/* Dropdown Menu */}
                {isMenuOpen && (
                    <div className={style.dropdownMenu}>
                        <NavLink to="/drivers" onClick={() => setIsMenuOpen(false)}>Drivers</NavLink>
                        <NavLink to="/teams" onClick={() => setIsMenuOpen(false)}>Teams</NavLink>
                    </div>
                )}
            </div>
        </nav >
    )
}

export default NavBar
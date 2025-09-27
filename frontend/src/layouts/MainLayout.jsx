import { Outlet } from "react-router-dom"

// components
import NavBar from "../components/NavBar"

function MainLayout() {

    return (
        <>
            <header>
                <NavBar />
            </header>
            <main>
                <Outlet />
            </main>
        </>
    )
}

export default MainLayout
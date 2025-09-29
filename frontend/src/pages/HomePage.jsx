import { Link } from "react-router-dom"

// style
import '../styles/pages/HomePage.css'

function HomePage() {

    return (
        <>
            <h1>Welcome to BoolF1</h1>

            <div className="text-box">
                <h3>Explore our</h3>
                <div className="btn-box">
                    <Link to="/drivers">Drivers</Link>
                    <Link to="/teams">Teams</Link>
                </div>
            </div>
        </>
    )
}

export default HomePage
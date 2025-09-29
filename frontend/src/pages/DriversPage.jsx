import { useEffect, useState } from 'react'
import { Link } from 'react-router-dom'

// components
import DriverCard from '../components/DriverCard'

// style
import '../styles/pages/DriversPage.css'

// api
import apiDrivers from '../services/apiDrivers'


function DriversPage() {

    const { getDrivers } = apiDrivers

    const [drivers, setDrivers] = useState([])

    useEffect(() => {
        getDrivers()
            .then(res => {
                const drivers = res.data.sort((a, b) => {
                    if (!a.team || !b.team) {
                        return 0
                    }
                    return a.team.id - b.team.id;
                })
                setDrivers(drivers)
            })
            .catch(err => {
                console.log(err)
                setDrivers([])
            })
    }, [])

    return (
        <>
            <h1>F1 Drivers 2025</h1>
            <div className="drivers-container">
                {drivers.length > 0 ? drivers.map(driver => (
                    <Link to={`/drivers/${driver.id}`} key={driver.id}>
                        <DriverCard data={driver} />
                    </Link>
                )) : (<p>No drivers found!</p>)}
            </div>
        </>
    )
}

export default DriversPage
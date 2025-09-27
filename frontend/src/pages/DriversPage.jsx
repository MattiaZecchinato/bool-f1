import { useEffect, useState } from "react"

// style
import '../styles/pages/DriversPage.css'

// api
import apiDrivers from "../services/apiDrivers"


function DriversPage() {

    const { getDrivers } = apiDrivers

    const [drivers, setDrivers] = useState([])

    useEffect(() => {
        getDrivers()
            .then(res => {
                setDrivers(res.data)
            })
            .catch(err => {
                console.log(err)
                setDrivers([])
            })
    }, [])

    return (
        <>
            <h1>Drivers</h1>
            {drivers.length > 0 ? drivers.map(driver => (
                <div key={driver.id}>
                    <p>{driver.firstName} {driver.lastName}</p>
                </div>
            )) : (<p>No drivers found!</p>)}
        </>
    )
}

export default DriversPage
import { useEffect, useState } from "react"
import { useParams } from "react-router-dom"

// components
import DriverDetailsCard from "../components/DriverDetailsCard"
import DriverStats from "../components/DriverStats"

// style
import '../styles/pages/DriverDetailsPage.css'

// api
import apiDrivers from "../services/apiDrivers"

function DriverDetailsPage() {

    const { id } = useParams();

    const { getDriverById } = apiDrivers

    const [driver, setDriver] = useState({})

    useEffect(() => {
        getDriverById(id)
            .then(res => {
                console.log(res.data)
                setDriver(res.data)
            })
            .catch(err => {
                console.log(err)
                setDriver({})
            })
    }, [id])

    return (
        <>
            {driver ? <>
                <div className="driver-box">
                    <DriverDetailsCard data={driver} />
                </div>
                <div className="stats-box">
                    <DriverStats data={driver} />
                </div>
            </> : (<p>Driver not found!</p>)}
        </>
    )
}

export default DriverDetailsPage
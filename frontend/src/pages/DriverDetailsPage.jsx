import { useContext, useEffect, useState } from 'react'
import { useParams } from 'react-router-dom'

// contexts
import LoaderContext from '../contexts/LoaderContext'

// components
import DriverDetailsCard from '../components/DriverDetailsCard'
import DriverStats from '../components/DriverStats'
import Loader from '../components/Loader'

// style
import '../styles/pages/DriverDetailsPage.css'

// api
import apiDrivers from '../services/apiDrivers'

function DriverDetailsPage() {

    const { id } = useParams();

    const { getDriverById } = apiDrivers

    const { isLoading, setIsLoading } = useContext(LoaderContext)

    const [driver, setDriver] = useState({})

    useEffect(() => {
        setIsLoading(true)
        getDriverById(id)
            .then(res => {
                console.log(res.data)
                setDriver(res.data)
            })
            .catch(err => {
                console.log(err)
                setDriver({})
            })
            .finally(() => setIsLoading(false))
    }, [id])

    return (
        <>
            {isLoading ? (<Loader />)
                : driver ? (<>
                    <div className="driver-box">
                        <DriverDetailsCard data={driver} />
                    </div>
                    <>
                        <DriverStats data={driver} />
                    </>
                </>) : (<p>Driver not found!</p>)
            }
        </>
    )
}

export default DriverDetailsPage
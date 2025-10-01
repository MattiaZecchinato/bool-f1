import { useContext, useEffect, useState } from 'react'
import { Link } from 'react-router-dom'

// contexts
import LoaderContext from '../contexts/LoaderContext'

// components
import DriverCard from '../components/DriverCard'
import Loader from '../components/Loader'

// style
import '../styles/pages/DriversPage.css'

// api
import apiDrivers from '../services/apiDrivers'


function DriversPage() {

    const { getDrivers } = apiDrivers

    const [drivers, setDrivers] = useState([])

    const { isLoading, setIsLoading } = useContext(LoaderContext)

    useEffect(() => {
        setIsLoading(true)
        getDrivers()
            .then(res => {
                setDrivers(res.data)
            })
            .catch(err => {
                console.log(err)
            })
            .finally(() => setIsLoading(false))
    }, [])

    return (
        <>
            {isLoading ? (<Loader />)
                : (<>
                    <h1>F1 Drivers 2025</h1>
                    <div className="drivers-container">
                        {drivers.length > 0 ? drivers.map(driver => (
                            <Link to={`/drivers/${driver.id}`} key={driver.id}>
                                <DriverCard isDriver={true} data={driver} />
                            </Link>
                        )) : (<p>No drivers found!</p>)}
                    </div>
                </>)
            }
        </>
    )
}

export default DriversPage
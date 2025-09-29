import { useState, useEffect, useContext } from 'react'
import { Link, useParams } from 'react-router-dom'

// contexts
import LoaderContext from '../contexts/LoaderContext'

// components
import TeamDetailsCard from '../components/TeamDetailsCard'
import DriverCard from '../components/DriverCard'
import Loader from '../components/Loader'

// style
import '../styles/pages/TeamDetailsPage.css'

// api
import apiTeams from '../services/apiTeams'

function TeamDetailsPage() {

    const { id } = useParams()

    const { getTeamsById } = apiTeams

    const { isLoading, setIsLoading } = useContext(LoaderContext)

    const [team, setTeam] = useState([])

    useEffect(() => {
        setIsLoading(true)
        getTeamsById(id)
            .then(res => {
                console.log(res.data)
                setTeam(res.data)
            })
            .catch(err => {
                console.log(err)
                setTeam([])
            })
            .finally(() => setIsLoading(false))
    }, [id])

    return (
        <>
            {isLoading ? (<Loader />)
                : team ? (<>
                    <div className="team-box">
                        <TeamDetailsCard data={team} />
                    </div>
                    <div className="lower-box">
                        <h2>Drivers</h2>
                        <div className="drivers-box">
                            {team.drivers?.length > 0 ? team.drivers?.map(driver => (
                                <Link to={`/drivers/${driver.id}`} key={driver.id}>
                                    <DriverCard key={driver.id} isDriver={false} data={driver} />
                                </Link>
                            )) : <></>}
                        </div>
                    </div>
                </>) : (<p>Team not found!</p>)}
        </>
    )
}

export default TeamDetailsPage
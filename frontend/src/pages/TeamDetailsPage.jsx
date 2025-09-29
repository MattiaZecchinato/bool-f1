import { useState, useEffect } from 'react'
import { Link, useParams } from 'react-router-dom'

// components
import TeamDetailsCard from '../components/TeamDetailsCard'
import DriverCard from '../components/DriverCard'

// style
import '../styles/pages/TeamDetailsPage.css'

// api
import apiTeams from '../services/apiTeams'

function TeamDetailsPage() {

    const { id } = useParams()

    const { getTeamsById } = apiTeams

    const [team, setTeam] = useState([])

    useEffect(() => {
        getTeamsById(id)
            .then(res => {
                console.log(res.data)
                setTeam(res.data)
            })
            .catch(err => {
                console.log(err)
                setTeam([])
            })
    }, [id])

    return (
        <>
            {team ? <>
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
            </> : (<p>Team not found!</p>)}
        </>
    )
}

export default TeamDetailsPage
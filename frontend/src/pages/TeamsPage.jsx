import { useEffect, useState } from 'react'
import { Link } from 'react-router-dom'

// components
import TeamCard from '../components/TeamCard'

// style
import '../styles/pages/TeamsPage.css'

// api
import apiTeams from '../services/apiTeams'

function TeamsPage() {

    const { getTeams } = apiTeams

    const [teams, setTeams] = useState([])

    useEffect(() => {
        getTeams()
            .then(res => {
                console.log(res.data)
                setTeams(res.data)
            })
            .catch(err => {
                console.log(err)
                setTeams([])
            })
    }, [])

    return (
        <>
            <h1>F1 Teams 2025</h1>
            <div className="teams-container">
                {teams.length > 0 ? teams.map(team => (
                    <Link to={`/teams/${team.id}`} key={team.id}>
                        <TeamCard data={team} />
                    </Link>
                )) : (<p>No teams found!</p>)}
            </div>
        </>
    )
}

export default TeamsPage
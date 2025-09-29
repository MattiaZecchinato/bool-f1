import { useContext, useEffect, useState } from 'react'
import { Link } from 'react-router-dom'

// contexts
import LoaderContext from '../contexts/LoaderContext'

// components
import TeamCard from '../components/TeamCard'
import Loader from '../components/Loader'

// style
import '../styles/pages/TeamsPage.css'

// api
import apiTeams from '../services/apiTeams'

function TeamsPage() {

    const { getTeams } = apiTeams

    const { isLoading, setIsLoading } = useContext(LoaderContext)

    const [teams, setTeams] = useState([])

    useEffect(() => {
        setIsLoading(true)
        getTeams()
            .then(res => {
                console.log(res.data)
                setTeams(res.data)
            })
            .catch(err => {
                console.log(err)
                setTeams([])
            })
            .finally(() => setIsLoading(false))
    }, [])

    return (
        <>
            {isLoading ? (<Loader />)
                : (<>
                    <h1>F1 Teams 2025</h1>
                    <div className="teams-container">
                        {teams.length > 0 ? teams.map(team => (
                            <Link to={`/teams/${team.id}`} key={team.id}>
                                <TeamCard data={team} />
                            </Link>
                        )) : (<p>No teams found!</p>)}
                    </div>
                </>)
            }
        </>
    )
}

export default TeamsPage
import { useParams } from "react-router-dom"
import { useState, useEffect } from "react"

// components
import TeamDetailsCard from "../components/TeamDetailsCard"

// style
import "../styles/pages/TeamDetailsPage.css"

// api
import apiTeams from "../services/apiTeams"

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
            {team ? <div className="team-box">
                <TeamDetailsCard data={team} />
            </div> : (<p>Team not found!</p>)}
        </>
    )
}

export default TeamDetailsPage
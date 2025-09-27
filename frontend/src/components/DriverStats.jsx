import '../styles/components/DriverStats.css'

function DriverStats({ data }) {

    const { podiums, wins, poles, wdc } = data

    return (
        <>
            <h2>STATISTICS</h2>
            <div className="info-stats-box">
                <h3>CAREER STATS</h3>
                <p>Podiums <span>{podiums}</span></p>
                <p>Wins <span>{wins}</span></p>
                <p>Poles <span>{poles}</span></p>
                <p>World Championships <span>{wdc}</span></p>
            </div>
        </>
    )
}

export default DriverStats
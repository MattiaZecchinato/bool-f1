function DriverStats({ data }) {

    const { podiums, wins, poles, wdc } = data

    return (
        <>
            <h2>STATISTICS</h2>
            <div className="info-stats-box">
                <h3>CAREER STATS</h3>
                <p>Podium: {podiums}</p>
                <p>Wins: {wins}</p>
                <p>Poles: {poles}</p>
                <p>Wdc: {wdc}</p>
            </div>
        </>
    )
}

export default DriverStats
import style from '../styles/components/DriverStats.module.css'

function DriverStats({ data }) {

    const { podiums, wins, poles, wdc } = data

    return (
        <>
            <div className={style.statsBox}>
                <h2>STATISTICS</h2>
                <div className={style.infoStatsBox}>
                    <h3>CAREER STATS</h3>
                    <p>Podiums <span>{podiums}</span></p>
                    <p>Wins <span>{wins}</span></p>
                    <p>Poles <span>{poles}</span></p>
                    <p>World Championships <span>{wdc}</span></p>
                </div>
            </div>
        </>
    )
}

export default DriverStats
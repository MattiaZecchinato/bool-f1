import style from "../styles/components/TeamCard.module.css"

function TeamCard({ data }) {

    const { name, logoImg, carImg, drivers, colorName } = data

    return (
        <div className={style.teamCard}
            style={{
                background: `linear-gradient(
                to right,
                var(--${colorName.toLowerCase().replace(' ', '')}) 0%,
                var(--${colorName.toLowerCase().replace(' ', '')}) 60%,
                color-mix(in srgb, var(--${colorName.toLowerCase().replace(' ', '')}) 70%, white 30%) 100%)`
            }}>
            <div className={style.topBox}>
                <div className={style.infoBox}>
                    <h3>{name}</h3>
                    <div className={style.driversBox}>
                        {drivers.length > 0 ? drivers.map(driver => (
                            <p key={driver.id}>
                                {driver.firstName} <span>{driver.lastName}</span>
                            </p>
                        )) : <></>}
                    </div>
                </div>
                <div className={style.logoBox}>
                    <img src={`/img/logoImg/${logoImg}`} alt={`${name} logo`} />
                </div>
            </div>
            <div className={style.carBox}>
                <img src={`/img/carImg/${carImg}`} alt={`${name} car`} />
            </div>
        </div >
    )
}

export default TeamCard
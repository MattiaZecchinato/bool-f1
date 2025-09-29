//style
import style from "../styles/components/TeamDetailsCard.module.css"

function TeamDetailsCard({ data }) {

    const { name, nationality, drivers, carImg, logoImg, colorName } = data

    return (
        <>
            <div className={style.teamCard} style={{ backgroundColor: `var(--${colorName?.toLowerCase().replace(' ', '')})` }}>
                <div className={style.carImgBox}>
                    <img src={`/img/carImg/${carImg}`} alt={`${name} car`} />
                </div>
                <div className="bottom-box">
                    <div className={style.infoBox}>
                        <h3>{name}</h3>
                    </div>
                    <div className={style.infoBox2}>
                        <p>{nationality}</p>
                        <div className={style.driversBox}>
                            {drivers?.length > 0 ? drivers.map(driver => (
                                <p key={driver.id}>
                                    {driver.firstName} {driver.lastName}
                                </p>
                            )) : <></>}
                        </div>
                    </div>
                    <div className={style.logoImgBox}>
                        <img src={`/img/logoImg/${logoImg}`} alt={`${name} logo`} />
                    </div>
                </div>
            </div>
        </>
    )
}

export default TeamDetailsCard
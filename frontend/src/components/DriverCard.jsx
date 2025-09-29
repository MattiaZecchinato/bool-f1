// style
import style from '../styles/components/DriverCard.module.css'

function DriverCard({ data }) {

    const { firstName, lastName, team, carNumber, pfpImage, nationality } = data

    return (
        <div className={style.driverCard} style={{ backgroundColor: `var(--${team?.colorName.toLowerCase().replace(' ', '')})` }}>
            <div className={style.leftBox}>
                <div className={style.infoBox}>
                    <p className={style.name}>{firstName}</p>
                    <p className={style.lastName}>{lastName}</p>
                    <p className={style.team}>{team?.name}</p>
                    <p className={style.carNumber}>{carNumber}</p>
                </div>
                <div className={style.nationalityBox}>
                    <p>{nationality}</p>
                </div>
            </div>
            <div className={style.imgBox}>
                <img src={`/img/driverImg/${pfpImage}`} alt={`${firstName} ${lastName}`} />
            </div>
        </div>
    )
}

export default DriverCard
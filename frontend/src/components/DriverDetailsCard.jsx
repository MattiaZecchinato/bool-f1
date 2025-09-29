// style
import style from '../styles/components/DriverDetailsCard.module.css'

function DriverDetailsCard({ data }) {

    const { firstName, lastName, nationality, carNumber, team, pfpImage } = data

    return (
        <div className={style.driverCard} style={{ backgroundColor: `var(--${team?.colorName.toLowerCase().replace(' ', '')})` }}>
            <div className={style.leftBox}>
                <div className={style.infoBox}>
                    <p className={style.firstName}>{firstName}</p>
                    <p className={style.lastName}>{lastName}</p>
                </div>
                <div className={style.infoBox2}>
                    <p>{nationality}</p>
                    <p>{team?.name}</p>
                    <p>{carNumber}</p>
                </div>
            </div>
            <div className={style.imgBox}>
                <img src={`/img/driverImg/${pfpImage}`} alt={`${firstName} ${lastName}`} />
            </div>
        </div>
    )
}

export default DriverDetailsCard
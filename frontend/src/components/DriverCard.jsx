import '../styles/components/DriverCard.css'

function DriverCard({ data }) {

    const { firstName, lastName, team, carNumber, pfpImage, nationality } = data

    return (
        <div className="driver-card" style={{ backgroundColor: `var(--${team?.colorName.toLowerCase().replace(' ', '')})` }}>
            <div className='left-box'>
                <div className="info-box">
                    <p className='name'>{firstName}</p>
                    <p className='last-name fw-bold'>{lastName}</p>
                    <p className='team'>{team?.name}</p>
                    <p className='car-number'>{carNumber}</p>
                </div>
                <div className='nationality-box'>
                    <p>{nationality}</p>
                </div>
            </div>
            <div className="img-box">
                <img src={`/img/driverImg/${pfpImage}`} alt={`${firstName} ${lastName}`} />
            </div>
        </div>
    )
}

export default DriverCard
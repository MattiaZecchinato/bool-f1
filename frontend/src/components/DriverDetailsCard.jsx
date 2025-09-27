function DriverDetailsCard({ data }) {

    const { firstName, lastName, nationality, carNumber, team, pfpImage } = data

    return (
        <div className="driver-card">
            <div className="left-box">
                <div className="info-box">
                    <p>{firstName}</p>
                    <p>{lastName}</p>
                </div>
                <div className="info-box-2">
                    <p>{nationality}</p>
                    <p>{team?.name}</p>
                    <p>{carNumber}</p>
                </div>
            </div>
            <div className="img-box">
                <img src={`/img/driverImg/${pfpImage}`} alt={`${firstName} ${lastName}`} />
            </div>
        </div>
    )
}

export default DriverDetailsCard
import { useContext } from 'react';

// contexts
import LoaderContext from '../contexts/LoaderContext';

// style
import style from '../styles/components/Loader.module.css'

function Loader() {

    const { isLoading } = useContext(LoaderContext);

    return (
        <>
            {isLoading ?
                (<div className={style.loaderBox}>
                    <span className={style.loader}></span>
                </div>) : (<></>)
            }
        </>
    )
}

export default Loader
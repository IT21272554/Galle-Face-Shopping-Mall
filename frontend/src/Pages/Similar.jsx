import axios from 'axios'
import React, { useEffect, useState } from 'react'
import { useParams } from 'react-router-dom'
import ItemBox from '../Components/ItemBox'

const Similar = () => {
    const { name } = useParams()
    const [items, setItems] = useState([])

    const getSimilarItems = async () => {
        try {
            const res =await axios.get(`${process.env.REACT_APP_API_URL}/search/items/${name}`)
            console.log(res.data);
            const data = res.data
            if(data.length  >0 ){
                setItems(data.filter((it)=>(it.inStock == true)))
            }
        } catch (error) {
            console.log(error);
        }
    }
    useEffect(() => {
        getSimilarItems()
    }, [])
    return (
        <div>
            <h2>Similar Items</h2>
            <br />
            <div className='grid grid-cols-2 md:grid-cols-3 xl:grid-cols-8 gap-2'>
                {
                   items?.length > 0 &&   items.map((it) => (
                        <ItemBox item={it} />
                    ))
                }
            </div>
        </div>
    )
}

export default Similar
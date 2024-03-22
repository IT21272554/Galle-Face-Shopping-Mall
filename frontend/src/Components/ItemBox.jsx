import React from 'react'
import { Link } from 'react-router-dom'

const ItemBox = ({ item }) => {
    return (
        <Link to={`/item/${item._id}`} className='relative px-0 min-w-40 py-0 bg-cyan-200 rounded-lg hover:scale-105' >
            <div className='w-full'>
                <img src={item.thumbnail[0] || 'https://www.shutterstock.com/image-vector/lost-items-line-vector-icon-260nw-1436787446.jpg'} className='w-full h-full object-cover' />
            </div>
            <div className='px-4 py-2 flex flex-col text-clip'>
                <span className='text-lg font-bold'>{item?.name || 'Not Available'}</span>
                <span className='text-xs font-semibold mb-2'>Rs : {item?.price}</span>
                <span className='text-xs text-nowrap'>{item?.description.length > 30 ? item.description.substring(0,30) : item.description}</span>
                <h2 className='text-xs text-gray-500 hidden'> Category : {item.category}</h2>
                <span className='px-2 absolute top-1 right-1 py-1 rounded-full text-xs w-max' style={{backgroundColor:item?.inStock ? 'lightgreen' : 'red'}}>{item?.inStock ? 'In Stock' : 'Out of stock' }</span>
                {!item?.inStock && <button className='text-xs px-1 py-1 bg-amber-500 hover:bg-amber-200'>Find Similar Products</button> }

            </div>


        </Link>
    )
}

export default ItemBox
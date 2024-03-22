import React from 'react'
import { Link } from 'react-router-dom'

const CategoryBox = ({ category }) => {
    return (
        <Link to={`/category/${category.catName}`} className='rounded-lg border hover:brightness-125 bg-green-400'>
            <img src={category.image || 'https://www.shutterstock.com/image-vector/lost-items-line-vector-icon-260nw-1436787446.jpg'} alt="" srcset="" className='w-full' />

            <div className='px-4 py-2'>
                {category.catName}
            </div>
        </Link>
    )
}

export default CategoryBox
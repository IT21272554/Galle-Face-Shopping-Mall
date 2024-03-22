import { Search } from '@mui/icons-material'
import axios from 'axios'
import React, { useEffect, useState } from 'react'
import { useNavigate } from 'react-router-dom'
import { toast } from 'react-toastify'
import CategoryBox from '../Components/CategoryBox'
import ItemBox from '../Components/ItemBox'
import Navbar from '../Components/NavBar'

const Find = () => {
    const [searchText, setSearch] = useState("")
    //const [categories, setCategories] = useState([]);
    const navigate = useNavigate()
    const [products, setProducts] = useState([]);
    const [text, setText] = useState('');
    const categories = [
        {
            _id: '1',
            catName: 'Apparel & Fashion'
        },
        {
            _id: '2',
            catName: 'Electronics & Technology'
        },
        {
            _id: '3',
            catName: 'Home & Decor'
        },
        {
            _id: '4',
            catName: 'Health & Beauty'
        },
        {
            _id: '5',
            catName: 'Food & Beverage'
        },
        {
            _id: '6',
            catName: 'Entertainment'
        },
        {
            _id: '7',
            catName: 'Services'
        },
        {
            _id: '8',
            catName: 'Specialty Stores'
        }
    ]

    // const getCategories = async ()=>{
    //     try {
    //         const res = await axios.get(`${process.env.REACT_APP_SERVER}/`);
    //         console.log(res.data);
    //     } catch (error) {

    //     }
    // }
    const handleNavigateToCat = (id) => {
        navigate()
    }

    // useEffect(() => {
    //     getCategories();
    // }, [])

    const searchItems = async () => {
        try {
            console.log('Items fetching...');
            if (text) {
                console.log(text);
                const items = await axios.get(`${process.env.REACT_APP_API_URL}/search/items/${text}`)
                console.log(items.data);
                setProducts(items.data);
                if(items.data.length < 1){
                    toast.error('No Result')
                }
            }
        } catch (error) {
            console.log(error);
        }
    }


    useEffect(() => {

        searchItems();


    }, [text])
    return (
        <div>
            <Navbar />
            <div>
                <div className='flex items-center justify-start rounded-lg overflow-hidden mt-2 w-full'>
                    <input type="text" placeholder='Search Products & Services' className='px-4 py-2 outline-none w-full' onChange={e => setText(e.target.value)} />
                    <button className='p-2 bg-green-300 w-max' onClick={searchItems}><Search /></button>
                </div>
            </div>
            <div className='grid grid-cols-2 md:grid-cols-3 xl:grid-cols-4 gap-4 my-10'>
                {
                    products.length < 1 && categories.map((cat) => (
                        <CategoryBox category={cat} />
                    ))
                }
                {
                   products.length > 0 && products.map((it) => (
                        <ItemBox item={it} />
                    ))
                }
            </div>
        </div>
    )
}

export default Find
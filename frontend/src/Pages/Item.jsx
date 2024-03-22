import axios from 'axios';
import React, { useEffect } from 'react';
import { useParams } from 'react-router-dom';
import { toast } from 'react-toastify';

const Item = () => {
    const {id} = useParams();
    const item = {
        images : [
           'https://www.shutterstock.com/image-vector/lost-items-line-vector-icon-260nw-1436787446.jpg',
           'https://www.shutterstock.com/image-vector/lost-items-line-vector-icon-260nw-1436787446.jpg',
           'https://www.shutterstock.com/image-vector/lost-items-line-vector-icon-260nw-1436787446.jpg',
           'https://www.shutterstock.com/image-vector/lost-items-line-vector-icon-260nw-1436787446.jpg'
        ]
    }

    const update = async()=>{
        try {
            const res = await axios.get(`${process.env.REACT_APP_API_URL}/history/save/${id}`)
            if(res.status == 200){
                toast.success('View Count Updated')
            }
        } catch (error) {
            console.log(error);
        }
    }

    useEffect(()=>{
            update()
    },[])
  return (
    <div>Item : {id}</div>
  )
}

export default Item
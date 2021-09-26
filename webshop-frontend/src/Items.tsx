import React from 'react';
import {Table} from 'react-bootstrap';
import {useQuery} from '@apollo/client';
import {FIND_ALL_ITEMS} from './Queries';

export const Items = () => {
    const {loading, error, data} = useQuery(FIND_ALL_ITEMS);

    if (loading) return <p>Loading...</p>;
    if (error) return <p>Error :(</p>;

    return <Table striped bordered hover>
        <thead>
        <tr>
            <th>#</th>
            <th>Name</th>
        </tr>
        </thead>
        <tbody>
        {
            data.findAll.map(({name}: { name: string }, index: number) => (
                <tr>
                    <td>{index}</td>
                    <td>{name}</td>
                </tr>
            ))
        }
        </tbody>
    </Table>;
}

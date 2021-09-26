import {gql} from "@apollo/client";

export const FIND_ALL_ITEMS = gql`
  query FindAllItems {
    findAll {
        id,
        name
    }
  }
`;

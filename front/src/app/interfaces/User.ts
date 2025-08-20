/* Register */
export interface UserRegisterInterface {
    username: string;
    email_address: string;
    password: string;
} 

/* Login */
export interface UserLoginInterface {
    usernameOrMail: string;
    password: string;
} 

export interface UserLoginResponseInterface {
    token: string;
}


/* Details */
export interface UserDetailsInterface {
    username: string;
    email_address: string;
    password: string;
} 


/* All infos */
export interface UserInterface {
    id_users: number;
    username: string;
    email_address: string;
    created_at: string;
    updated_at: string;
} 
export interface PostInterface {
    id_posts: number;
    title: string;
    updated_at: string;
    author: string;
    topic: string;
    content: string;
    id_users: {
        username: string;
    };
} 
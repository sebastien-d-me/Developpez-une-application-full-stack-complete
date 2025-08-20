export interface CommentsInterface {
    id_comments: number;
    updated_at: string;
    author: string;
    content: string;
    id_users: {
        username: string;
    };
} 

// Request
export interface CommentsRequest {
    postId: number;
    content: string;
}